public class Planet {

	private double xxPos;
	private double yyPos;
	private double xxVel;
	private double yyVel;
	private double mass;
	private String imgFileName;
	// static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		double xDis = xxPos - p.xxPos;
		double yDis = yyPos - p.yyPos;
		return Math.sqrt(xDis*xDis + yDis*yDis);
	}

	public double calcForceExertedBy(Planet p){
		double G = 6.67e-11;
		double dis = this.calcDistance(p);
		return G * this.mass * p.mass / dis / dis;
	}

	public double calcForceExertedByX(Planet p){
		double force = calcForceExertedBy(p);
		double dis = this.calcDistance(p);
		return (p.xxPos - this.xxPos) * force / dis;
	}

	public double calcForceExertedByY(Planet p){
		double force = calcForceExertedBy(p);
		double dis = this.calcDistance(p);
		return (p.yyPos - this.yyPos) * force / dis;
	}

	public double calcNetForceExertedByX(Planet[] pArr){
		double output = 0;
		for(Planet p : pArr){
			if(this.equals(p)){
				continue;
			}
			output += calcForceExertedByX(p);
		}
		return output;
	}

	public double calcNetForceExertedByY(Planet[] pArr){
		double output = 0;
		for(Planet p : pArr){
			if(this.equals(p)){
				continue;
			}
			output += calcForceExertedByY(p);
		}
		return output;
	}

	//For motion, update the position of planet every dt.
	public void update(double dt, double fx, double fy){
		double aX = fx / this.mass;
		double aY = fy / this.mass;

		xxVel += dt*aX;
		yyVel += dt*aY;

		xxPos += dt*xxVel;
		yyPos += dt*yyVel;
	}

	//Draw planet picture in the canvas.
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
	}

}
