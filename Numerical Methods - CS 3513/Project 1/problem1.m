close all; clear all; clc;


M = 0:.1:2*pi;
%%%e = 0:.1/(2*pi):1; %% /2pi in order to be same size array .1

E = 1; 

a = 5 * 10^11;
b = 4 * 10^11;
c = sqrt(a^2 - b^2);
e = c/a;

a2 = 6 * 10^11;
b2 = 3 * 10^11;

tolerance = 0.000001;
iterations = 20;

f = M - E + e * sin(E);
df = -1 + e*cos(E);

i = 0;
while ( i <= iterations )
    Enext = E - (f)/(df);
    Error = abs((Enext - E)/Enext);
    E = Enext;
    if(Error <= tolerance)
        break;
    end
    
    f = M - E + e * sin(E);
    df = -1 + e*cos(E);
    
    i = i+1;
end

x = a.*cos(E - e);
y = a.*sqrt(1-e^2).*sin(E);


x2 = a2.*cos(E - e);
y2 = a2.*sqrt(1-e^2).*sin(E);


plot(x,y), hold on;
plot(x2,y2)
legend("A1, B1", "A2, B2");
ylabel('Distance [Miles]');
xlabel('Distance [Miles]');
title("Kepler's Planetary Motion");

