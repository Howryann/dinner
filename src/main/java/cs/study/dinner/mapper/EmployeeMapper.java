package cs.study.dinner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cs.study.dinner.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
