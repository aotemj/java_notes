package DbUtils.demo1;

public class Account {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    private String money;

    public Account() {

    }

    public Account(int id, String name, String money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money='" + money + '\'' +
                '}';
    }
}
