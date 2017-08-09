package playing.nope;

public class Somhow extends Something {
	
	private boolean hot;

	public Somhow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isHot() {
		return hot;
	}

	public void setHot(boolean hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		return   super.toString() + "Somhow [hot=" + hot + "]";
	}

	
}
