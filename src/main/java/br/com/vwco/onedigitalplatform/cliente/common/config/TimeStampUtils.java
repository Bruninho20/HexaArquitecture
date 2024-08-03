package br.com.vwco.onedigitalplatform.cliente.common.config;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class TimeStampUtils {

	private TimeStampUtils() {
	}

	public static Timestamp getBrasilitaTimestamp() {
		ZoneId brZone = ZoneId.of("America/Sao_Paulo");
		LocalDateTime brasiliaDateTime = LocalDateTime.now(brZone);
		return Timestamp.valueOf(brasiliaDateTime);
	}

}
