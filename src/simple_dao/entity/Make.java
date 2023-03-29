package simple_dao.entity;

public class Make {

    private long id;
    private String make;

    public Make(long id, String make) {
        this.id = id;
        this.make = make;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Make {" + " id = " + id + ", make = '" + make + '\'' + '}';
    }
}
