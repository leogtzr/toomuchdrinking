package toomuchdrinking.bean;

import java.util.List;

public class MillilitersPerDayResponse {

    private boolean ok;
    private List<MillilitersPerDay> mls;

    public MillilitersPerDayResponse() {}

    public MillilitersPerDayResponse(final boolean ok, final List<MillilitersPerDay> mls) {
        this.ok = ok;
        this.mls = mls;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(final boolean ok) {
        this.ok = ok;
    }

    public List<MillilitersPerDay> getMls() {
        return mls;
    }

    public void setMls(final List<MillilitersPerDay> mls) {
        this.mls = mls;
    }

    @Override
    public String toString() {
        return "MillilitersPerDayResponse{" +
                "ok=" + ok +
                ", mls=" + mls +
                '}';
    }
}
