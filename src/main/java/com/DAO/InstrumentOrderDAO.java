package com.DAO;

import java.util.List;

import com.entity.Instrument_Order;

public interface InstrumentOrderDAO {
	public boolean saveOrder2(List<Instrument_Order> ilist);

	public List<Instrument_Order> getInstrument(String email);

	public List<Instrument_Order> getAllorder();

}
