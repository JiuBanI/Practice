package entity;


/**
 * Created by 涔呬即銆�on 2018/1/25.
 */
//鍒嗙被
public class Kind {

    private int kind_id;
    private String use;
    private String kind_name;

    public int getKind_id() {
        return kind_id;
    }

    public void setKind_id(int kind_id) {
        this.kind_id = kind_id;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getKind_name() {
        return kind_name;
    }

    public void setKind_name(String kind_name) {
        this.kind_name = kind_name;
    }

    public Kind() {
    }

    public Kind(int kind_id, String use, String kind_name) {
        this.kind_id = kind_id;
        this.use = use;
        this.kind_name = kind_name;
    }
}
