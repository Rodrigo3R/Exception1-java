package modo.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long  duration() {
		
		
		// calculando a diferença do tempo e colocando em dias.
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			
			return "Reservation dates for update must be futures date.";
			
		} 
		if (!checkOut.after(checkIn)) {
			
			return "Check-Out date must be after check-in date.";
			
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;
	}
	
	@Override
	public String toString() {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("Room: ");
		sb.append(roomNumber + "\ncheckIn: ");
		sb.append(sdf.format(checkIn) + "\n");
		sb.append("ckeckOut: ");
		sb.append(sdf.format(checkOut) + "\n");
		sb.append(duration() + " nights");
		
		return sb.toString();
	}
	
}

