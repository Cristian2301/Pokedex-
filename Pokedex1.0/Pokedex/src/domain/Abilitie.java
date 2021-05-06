package domain;

public class Abilitie 
{
	private String name;
	private eType type;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public eType getType()
	{
		return this.type;
	}

	public void setType(eType type)
	{
		this.type = type;
	}
	
	public Abilitie(String name, eType type)
	{
		if(type != null && name != null)
		{	
			this.setType(type);
			this.setName(name);
		}
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nAbilitie\n");
		sb.append("Name: " + this.getName()+ "\n");
		sb.append("Type: " + this.getType() + "\n");
		
		return sb.toString();
	}

}