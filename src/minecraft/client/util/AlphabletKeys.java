package client.util;

public enum AlphabletKeys {
	q(Row.s),
	w(Row.s),
	e(Row.s),
	r(Row.s),
	t(Row.s),
	y(Row.s),
	u(Row.s),
	i(Row.s),
	o(Row.s),
	p(Row.s),
	a(Row.t),
	s(Row.t),
	d(Row.t),
	f(Row.t),
	g(Row.t),
	h(Row.t),
	j(Row.t),
	k(Row.t),
	l(Row.t),
	z(Row.fo),
	x(Row.fo),
	c(Row.fo),
	v(Row.fo),
	b(Row.fo),
	n(Row.fo),
	m(Row.fo);

	public Row row;
	AlphabletKeys(Row row) {
		this.row = row;
	}
	public Row getRow() {
		return row;
		
	}
}
