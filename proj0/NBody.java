

public class NBody {

	//Radius for the universe and canvas.
	public static double readRadius(String filename){
		In in = new In(filename);

		int line = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String filename){
		In in = new In(filename);

		int line = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[line];
		int j=0;

		while(j<line){
			double xPos = in.readDouble();
			double yPos = in.readDouble();
			double xVel = in.readDouble();
			double yVel = in.readDouble();
			double mass = in.readDouble();
			String name = in.readString();
			// for(int i=0;i<name.length();i++){
			// 	if(name.charAt(i) == '.'){
			// 		name = name.substring(0,i);
			// 	}
			// 	break;
			// }
			planets[j] = new Planet(xPos, yPos, xVel, yVel, mass, name);
			j++;
		}
		return planets;
	}

	public static void main(String[] args){
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets= readPlanets(filename);

		//Set canvas to double size of radius.
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();

		String imageToDraw = "images/starfield.jpg";
		StdDraw.picture(0, 0, imageToDraw);

		for(Planet p : planets){
			p.draw();
		}

		//Allow animation.
		StdDraw.enableDoubleBuffering();

		double time = 0.0;
		while(time <= T){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];

			for(int i=0;i<planets.length;i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for(int i=0;i<planets.length;i++){
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.picture(0, 0, imageToDraw);

			for(Planet p : planets){
				p.draw();
			}
			StdDraw.show();
			StdDraw.pause(200);
			time += dt;
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
		    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		                  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		                  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}


}