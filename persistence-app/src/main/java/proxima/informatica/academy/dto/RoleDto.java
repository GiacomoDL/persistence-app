package proxima.informatica.academy.dto;

/**
 * 
 * @author Giacomo Della Luna
 *
 */
public class RoleDto {

	private Integer id;
	private String label;
	private String description;
	private Integer level;
	
	public RoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoleDto(Integer id, String label, String description, Integer level) {
		super();
		this.id = id;
		this.label = label;
		this.description = description;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "RoleDto [id=" + id + ", label=" + label + ", description=" + description + ", level=" + level + "]";
	}
	
}
