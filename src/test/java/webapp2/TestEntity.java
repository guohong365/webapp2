package webapp2;

import java.sql.Date;

import com.uc.web.tools.annotation.AutoGenerateEntity;
import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.annotation.FormField;

@AutoGenerateEntity("测试")
public class TestEntity {
	@FormField(hidden=true)
	private Long id;
	@FormField(value="名称", range=true, required=true)
	private String name;
	@FormField(value="描述", component=ComponentType.TEXT_AREA)
	private String description;
	@FormField("有效")
	private Boolean valid;
	@FormField("使用时间")
	private Date useTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public Date getUseTime() {
		return useTime;
	}
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

}
