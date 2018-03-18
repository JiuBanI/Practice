package entity;

/**
 * Created by 涔呬即銆�on 2018/1/25.
 */
//鍥剧墖
public class Images {
    private  int image_id;
    private String image_name;
    private String use;
    private int use_id;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public int getUse_id() {
        return use_id;
    }

    public void setUse_id(int use_id) {
        this.use_id = use_id;
    }

    public Images() {
    }

    public Images(int image_id, String image_name, String use, int use_id) {
        this.image_id = image_id;
        this.image_name = image_name;
        this.use = use;
        this.use_id = use_id;
    }
}
