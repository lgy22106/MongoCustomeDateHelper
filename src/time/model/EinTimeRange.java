package time.model;

public class EinTimeRange {
	private EinTime begin;
	private EinTime end;
	
	/**
	 * one query model might contain muti time ranges, so i need another layer to represent this possiblity
	 * @param begin
	 * @param end
	 */
	public EinTimeRange(EinTime begin, EinTime end) {
		this.begin = begin;
		this.end = end;
	}
	
	public EinTimeRange(EinTime time) {
		this.begin = time;
		this.end = null;
	}

	public EinTime getBegin() {
		return begin;
	}

	public void setBegin(EinTime begin) {
		this.begin = begin;
	}

	public EinTime getEnd() {
		return end;
	}

	public void setEnd(EinTime end) {
		this.end = end;
	}
	
}
