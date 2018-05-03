close all; clear *; clc;

%%%Problem1: 

%%%CONSTANTS, Provided by professor:
RESISTANCE = 200;
VOLTAGE = 5;
INDUCTANCE = 1; %%% 1H
CAPACITANCE = .000001; %%% C =1?F
INTERVAL = .1;

%%% Form a system of equations
%%% Use first derivative of V "z"
f_xyz = @(x, y, z) z;
g_xyz = @(x, y, z) (VOLTAGE - RESISTANCE * CAPACITANCE * z - y) / CAPACITANCE * INDUCTANCE;
dz = @(Vc, z) VOLTAGE * 10^6 - 10^6 * Vc - 200 * z;

v(1) = 0;
dv(1) = 0;
ddv_c(1) = 0;

h = 0.0005;
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
    ddv_c(counter+1) = dz(v(counter), dv(counter+1)); 
    
    counter = counter + 1;
end 
v(end) = [];
dv(end) = [];
ddv_c(end) = [];

%%%Plots for problem 3:

%%%Plot for capacitor:
plot(t,v);
title('Voltage change in the capacitor while charging for 0.1 seconds');
ylabel('Volts [v]');
xlabel('Time [s]');

%%% Plot for resistor:
figure;
current = dv.*CAPACITANCE;
Voltage_resistor = current*RESISTANCE;
plot(t,Voltage_resistor);
title('Voltage change in the resistor while charging for 0.1 seconds');
ylabel('Volts [v]');
xlabel('Time [s]');

%%% Plot for inductor:
figure;
Voltage_inductor = ddv_c.*CAPACITANCE.*INDUCTANCE;
plot(t, Voltage_inductor);
title('Voltage change in the inductor while charging for 0.1 seconds');
ylabel('Volts [v]');
xlabel('Time [s]');


%%%Answer to problem 1:
disp('Problem 1: ');
disp(['The voltage at time ' num2str(t(end)) ' was ' num2str(v(end)), ' volts'])


%%% Problem 2:
disp(newline);
disp('Problem 2:')


prevV = v(end);
prevT = t(end);
prevDV = dv(end);
prev_ddv_c = ddv_c(end);
%%% Reset the values of t, v, and dv
t = [];
v = [];
dv = [];
ddv_c = [];

%%% set v and dv initial conditions to previous conditions
%%t = prevT:h:prevT*2;
VOLTAGE = 0; %% source off
f_xyz = @(x, y, z) z;
g_xyz = @(x, y, z) (VOLTAGE - RESISTANCE * CAPACITANCE * z - y) / CAPACITANCE * INDUCTANCE;
dz = @(Vc, z) VOLTAGE * 10^6 - 10^6 * Vc - 200 * z;

ddv_c(1) = prev_ddv_c;
v(1) = prevV;
dv(1) = prevDV;
t = prevT;
counter = 1;
maxIterations = 500;
tolerance = .0001;
while counter < maxIterations
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
    ddv_c(counter+1) = dz(v(counter), dv(counter+1)); 
        
    t = [t t(end)+h];
    
    if abs(v(end)) < tolerance
        break;
    end
    counter = counter + 1;
end

%%%Plots for problem 3:

%%%Plot for capacitor
figure;
plot(t,v);
xlabel('Time [s]');
ylabel('Volts [v]');
title('Voltage change in the capacitor when power source is disconnected');


%%%Plot for resistor:
figure;
current = dv.*CAPACITANCE;
Voltage_resistor = current*RESISTANCE;
plot(t,Voltage_resistor);
title('Voltage change in the resistor when power source is disconnected');
ylabel('Volts [v]');
xlabel('Time [s]');

%%% Plot for inductor:
figure;
Voltage_inductor = ddv_c.*CAPACITANCE.*INDUCTANCE;
plot(t, Voltage_inductor);
title('Voltage change in the inductor when power source is disconnected');
ylabel('Volts [v]');
xlabel('Time [s]');

%%%Answer to problem 2:
disp(['Starting at time ' num2str(t(1)) 's it took ' num2str(t(end)-t(1)) ' seconds to discharge the capacitor.']) 
disp(['The above mentioned value is with a tolerance for zero of ' num2str(tolerance)])

%%% Problem 3:
disp(newline);
disp('Problem 3:');
disp('See graphs, figures 1 - 6.');


%%% Problem 4:
disp(newline);
disp('Problem 4:');

%%%Energy change for capacitor:
figure;

energy_c = CAPACITANCE/2 .* v.^2;
plot(t,energy_c)

xlabel('Time [s]');
ylabel('Volts [v]');
title('Energy change in the capacitor while system is discharging');
%%%Energy change for inductor:
figure;

energy_l = INDUCTANCE/2.*current.^2;
plot(t,energy_l)

xlabel('Time [s]');
ylabel('Volts [v]');
title('Energy change in the inductor while system is discharging');

%%% Sum of energy for both the inductor and resistor
figure;

energy_lc = energy_l + energy_c;
plot(t, energy_lc);

xlabel('Time [s]');
ylabel('Watts [W]');
title('Energy change in the system while the system is discharging');

%%% Find interpolated function for energy change in system so we can find
%%% area

intervals = size(t,2)-1;
deltax = (t(end) - t(1))/intervals;


%%%First sum of simpson 3/8

counter = 2;
firstSum = 0;
while counter < size(energy_lc,2)-2
    firstSum = firstSum + energy_lc(counter);
    counter = counter + 3;
end

%%% Second sum of simpson 3/8
counter = 3;
secondSum = 0;
while counter < size(energy_lc,2)-1
    secondSum = secondSum + energy_lc(counter);
    counter = counter + 3;
end

%%% Third sum of simpson 3/8
counter = 4;
thirdSum = 0;
while counter < size(energy_lc,2)-3
    thirdSum = thirdSum + energy_lc(counter);
    counter = counter + 3;
end

%%% Simpson 3 /8 
total_energy_change = (3*deltax/8)*(energy_lc(1))+3*firstSum+3*secondSum+2*thirdSum+energy_lc(end);
disp(['The total energy change for the system while discharging is ' num2str(total_energy_change) ' watts per second']);

%%% Problem 5:
disp(newline);
disp('Problem 5:');

counter = 1;
sumW = 0;
sumZ = 0;
sumWsquared = 0;
sumWZ = 0;
while counter < size(t,2)
    z = log(energy_lc(counter));
    w = t(counter);
    sumW = sumW + w;
    sumZ = sumZ + z;
    sumWsquared = sumWsquared + w*w;
    sumWZ = sumWZ + w*z;
    counter = counter + 1;
end

powerModel = [size(t,2), sumW;sumW, sumWsquared];
powerModel_solutionVector = [sumZ; sumWZ];
powerModel_solutions = rref([powerModel powerModel_solutionVector]);

b0= powerModel_solutions(1, end);
b1 = powerModel_solutions(2, end);
a0 = exp(b0);
a1 = b1;

n = a0 * exp(a1*t);

figure;
plot(t, n);
xlabel('Time [s]');
ylabel('Watts [W]');
title('Power Model regression of energy change in the system while the system is discharging');


%%% Problem 6:
disp(newline);
disp('Problem 6:');


