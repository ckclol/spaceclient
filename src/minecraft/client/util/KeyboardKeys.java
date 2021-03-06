package client.util;

public enum KeyboardKeys {
	f1(Row.f),
	f2(Row.f),
	f3(Row.f),
	f4(Row.f),
	f5(Row.f),
	f6(Row.f),
	f7(Row.f),
	f8(Row.f),
	f9(Row.f),
	f10(Row.f),
	f11(Row.f),
	f12(Row.f),
	prtsc(Row.f),
	scrlk(Row.f),
	pause(Row.f),
	tilter(Row.s),
	emark(Row.s),
	at(Row.s),
	ht(Row.s),
	ds(Row.s),
	pt(Row.s),
	up(Row.s),
	and(Row.s),
	star(Row.s),
	ll(Row.s),
	rl(Row.s),
	mm(Row.s),
	eq(Row.s),
	bs(Row.s),
	ins(Row.s),
	home(Row.s),
	pyup(Row.s),
	tab(Row.t),
	lqf(Row.t),
	rqf(Row.t),
	bsl(Row.t),
	del(Row.t),
	end(Row.t),
	pgdn(Row.t),
	caps(Row.fo),
	sc(Row.fo),
	sqm(Row.fo),
	enter(Row.fo),
	ls(Row.fi),
	co(Row.fi),
	fs(Row.fi),
	sl(Row.fi),
	rs(Row.fi),
	aup(Row.fi),
	lctrl(Row.si),
	win(Row.si),
	lalt(Row.si),
	space(Row.si),
	ralt(Row.si),
	fn(Row.si),
	hlo(Row.si),
	rctrl(Row.si),
	ale(Row.si),
	ado(Row.si),
	ari(Row.si);
	

	public Row row;
	
	KeyboardKeys(Row row) {
		
		this.row = row;
		
	}
	public Row getRow() {
		
		return row;
		
	}
}
