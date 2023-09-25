package com.DAO;

import java.util.List;

import com.entity.instrument;

public interface InstrumentDAO {
	public boolean addinstrument(instrument i);

	public List<instrument> getAllInstruments();

	public boolean deleteInstrument(int id);

	public List<instrument> getInstruments();

	public instrument getInstrumentById(int id);
}
