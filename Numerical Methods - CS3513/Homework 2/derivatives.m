%%% Michael McQuade A01677104, Josh McMahan A01677115
%%% Homework 2 for Numerical Methods
%%%Finds the high accuracy first derivatives for log(x)-9x, and finds the
%%% second derivatives for the same function. Graphs them in relation to
%%% the real first and second derivatives.

close all, clc, clear all;

delta = 0.1;
x = 0:delta:10;
y = log(x) - 9*x;
%%%%%%
dy = 1./x - 9; % real derivative
dy2 = -1./x.^2; % real second derivative

%%% higher accuracy first derivative - forward 
for i = 1 : size(x,2)-2
    dyForward(i) = (-y(i+2)+4*y(i+1)-3*y(i))/(2*(x(i+1)-x(i)));
end


%%% higher accuracy first derivative - backward
for i = 3 : size(x,2) - 2
    dyBackward(i) = (3*y(i)-4*y(i-1)+y(i-2))/(2*(x(i+1)-x(i)));
end

%%% higher accuracy first derivative - centered
for i = 3 : size(x,2) - 2
    dyCentered(i) = (-y(i+2)+8*y(i+1)-8*y(i-1)+y(i-2))/(12*(x(i+1)-x(i)));
end

%%% plot first derivatives
f1 = figure;
plot(x,dy,'r-'), hold on;
plot(x(1:end-2),dyForward,'b-');
plot(x(3:end),dyBackward,'g-');
plot(x(3:end),dyCentered,'m-');
title('First derivatives of log(x) - 9x');
xlabel('[NU]');
ylabel('[NU]');
legend('Real 1st derivative', 'Forward High Accuracy 1st derivative', 'Backward High Accuracy 1st derivative', 'Centered High Accuracy 1st derivative');


%%% higher accuracy second derivative - forward 
for i = 1 : size(x,2)-2
    dy2Forward(i) = (y(i+2)-2*y(i+1)+y(i))/(((x(i+1)-x(i)))^2);
end


%%% higher accuracy second derivative - backward
for i = 3 : size(x,2) - 2
    dy2Backward(i) = (y(i)-2*y(i-1)+y(i-2))/(((x(i+1)-x(i)))^2);
end

%%% higher accuracy second derivative - centered
for i = 2 : size(x,2) - 1
    dy2Centered(i) = (y(i+1)-2*y(i)+y(i-1))/(((x(i+1)-x(i)))^2);
end

%%% plot second derivatives
f2 = figure;
plot(x,dy2,'r--'), hold on
plot(x(1:end-2),dy2Forward,'b--');
plot(x(3:end),dy2Backward,'g--');
plot(x(2:end), dy2Centered, 'm--');
title('Second derivatives of log(x) - 9x');
xlabel('[NU]');
ylabel('[NU]');
legend('Real 2nd derivative', 'Forward 2nd derivative', 'Backward 2nd derivative', 'Centered 2nd derivative');

movegui(f1, 'west');
movegui(f2, 'east');
