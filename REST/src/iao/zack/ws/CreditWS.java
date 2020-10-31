package iao.zack.ws;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;


@Path("/credit")
public class CreditWS {
	
	
@GET
	@Path("/hello")
	public String hello() {
		return "hello world";
	}
	
	@GET
	@Path("/calculMensualite")
	public double calculMensualite(@QueryParam("capital") double c ,@QueryParam("duree") int n ,@QueryParam("taux") double t) {

		double tm = Math.pow(1 + t, (double) 1 / 12) - 1;
		double a = Math.pow(1 + tm, n) * tm * c / (Math.pow(1 + tm, n) - 1);
		return a;

	}
	
	@GET
	@Path("/calculCapital")
	public double calculCapital(@QueryParam("annuitee") double a, @QueryParam("duree") int n ,@QueryParam("taux") double t) {

		double tm = Math.pow(1 + t, (double) 1 / 12) - 1;
		double c = (a * (Math.pow(1 + tm, n) - 1)) / (Math.pow(1 + tm, n) * tm);
		return c;

	}
	
	@GET
	@Path("/calculDuree")
	public int calculDuree(@QueryParam("capital") double c ,@QueryParam("annuitee") double a,@QueryParam("taux") double t) {

		double tm = Math.pow(1 + t, (double) 1 / 12) - 1;
		double n = Math.log(a / (a - (tm * c))) / Math.log(1 + tm);
		return (int) Math.round(n);

	}

}
