package Model;

public class Snacks {
	private int id;
	private String name;
	private String desc;
	private int price;

	public Snacks(int id, String name, String desc, int price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	@Override
	public String toString() {
		return "id=" + id + "\tname=" + name + "\tdesc=" + desc + "\tprice=" + price + "\n";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
