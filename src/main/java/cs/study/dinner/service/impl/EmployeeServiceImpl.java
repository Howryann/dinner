package cs.study.dinner.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cs.study.dinner.entity.Employee;
import cs.study.dinner.mapper.EmployeeMapper;
import cs.study.dinner.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
}
