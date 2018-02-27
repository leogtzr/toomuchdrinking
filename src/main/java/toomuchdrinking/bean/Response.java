package toomuchdrinking.bean;

import java.util.List;

public class Response {

    private boolean ok;
    private List<Need> needs;

    public Response() {}

    public Response(final boolean ok, final List<Need> needs) {
        this.ok = ok;
        this.needs = needs;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(final boolean ok) {
        this.ok = ok;
    }

    public List<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(final List<Need> needs) {
        this.needs = needs;
    }

    @Override
    public String toString() {
        return "Response{" +
                "ok=" + ok +
                ", needs=" + needs +
                '}';
    }
}
