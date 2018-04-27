close all; clear *; clc;
%%%CONSTANTS, Provided by professor:
RESISTANCE = 200;
VOLTAGE = 5;
INDUCTANCE = 1; %%% 1H
CAPACITANCE = .000001; %%% C =1?F
INTERVAL = .1;

%%% q is charge
%%% z is derivative of q

%%% Form a system of equations
%%% Use first derivative of V "z"
f_xyz = @(x, y, z) z;
g_xyz = @(x, y, z) (VOLTAGE - RESISTANCE * CAPACITANCE * z - y) / CAPACITANCE * INDUCTANCE;

v(1) = 0;
dv(1) = 0;

h = 0.0005; %%% (t_n - t_0)/n
t = 0:h:.1;
counter = 1;

for ti = t
    k0 = h * f_xyz(t(counter), v(counter), dv(counter));
    l0 = h * g_xyz(t(counter), v(counter), dv(counter));
    k1 = h * f_xyz(t(counter) + h/2, v(counter) + k0/2, dv(counter) + l0/2);
    l1 = h * g_xyz(t(counter) + h/2, v(counter) + k0/2, dv(counter) + l0/2);
    k2 = h * f_xyz(t(counter) + h/2, v(counter) + k1/2, dv(counter) + l1/2);
    l2 = h * g_xyz(t(counter) + h/2, v(counter) + k1/2, dv(counter) + l1/2);
    k3 = h * f_xyz(t(counter) + h, v(counter) + k2, dv(counter) + l2);
    l3 = h * g_xyz(t(counter) + h, v(counter) + k2, dv(counter) + l2);
    v(counter+1) = v(counter) + (k0 + 2*k1 + 2*k2 + k3)/6;
    dv(counter+1) = dv(counter) + (l0 + 2*l1 + 2* l2 + l3)/6;
    
    counter = counter + 1;
end 

plot(v,dv)
