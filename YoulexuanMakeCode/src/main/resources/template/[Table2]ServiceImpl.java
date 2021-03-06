package [package].service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import [path_1].[path_2].mapper.Tb[Table2]Mapper;
import [path_1].[path_2].pojo.Tb[Table2];
import com.offcn.pojo.Tb[Table2]Example;
import com.offcn.pojo.Tb[Table2]Example.Criteria;
import [package].service.[Table2]Service;

import com.offcn.entity.PageResult;

/**
 * [comment]服务实现层
 * @author Administrator
 *
 */
@Service
public class [Table2]ServiceImpl implements [Table2]Service {

	@Autowired
	private Tb[Table2]Mapper [table2]Mapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Tb[Table2]> findAll() {
		return [table2]Mapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<Tb[Table2]> page=   (Page<Tb[Table2]>) [table2]Mapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Tb[Table2] [table2]) {
		[table2]Mapper.insert([table2]);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Tb[Table2] [table2]){
		[table2]Mapper.updateByPrimaryKey([table2]);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Tb[Table2] findOne([PrimaryKeyType] [PrimaryKeyName]){
		return [table2]Mapper.selectByPrimaryKey([PrimaryKeyName]);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete([PrimaryKeyType][] [PrimaryKeyName]s) {
		for([PrimaryKeyType] [PrimaryKeyName]:[PrimaryKeyName]s){
			[table2]Mapper.deleteByPrimaryKey([PrimaryKeyName]);
		}		
	}
	
	
		@Override
	public PageResult findPage(Tb[Table2] [table2], int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		Tb[Table2]Example example=new Tb[Table2]Example();
		Criteria criteria = example.createCriteria();
		
		if([table2]!=null){			
			[queryParms]	
		}
		
		Page<Tb[Table2]> page= (Page<Tb[Table2]>)[table2]Mapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
	
}
