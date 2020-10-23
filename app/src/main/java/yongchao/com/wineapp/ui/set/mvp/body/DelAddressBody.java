package yongchao.com.wineapp.ui.set.mvp.body;

import java.util.List;

public class DelAddressBody {


    private List<Integer> addressIds;

    public List<Integer> getAddressIds() {
        return addressIds;
    }

    public void setAddressIds(List<Integer> addressIds) {
        this.addressIds = addressIds;
    }

    public DelAddressBody(List<Integer> addressIds) {
        this.addressIds = addressIds;
    }
}
