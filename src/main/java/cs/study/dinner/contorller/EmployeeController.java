package cs.study.dinner.contorller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cs.study.dinner.common.R;
import cs.study.dinner.entity.Employee;
import cs.study.dinner.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public R<Employee> login(@RequestBody Employee employee){
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        if (emp == null) {
            return R.error("用户不存在");
        }
        if (!emp.getPassword().equals(employee.getPassword())) {
            return R.error("密码错误");
        }
        if(emp.getStatus() == 0){
            return R.error("账号被禁用");
        }
        return R.success(emp);
    }

}
