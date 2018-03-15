clc, close all, clear all
f = @(a) a.^4 - 10*a.^3 + 27*a.^2 - 2*a - 40;
fprime = @(b) 4*b.^3 - 30*b.^2 + 54*b - 2;


syms x;
ycc = factor(x.^4 - 10*x.^3 + 27*x.^2 - 2*x - 40);
count = size(ycc);
ic = 0;
icc = 0;
interval = [-3, 4];

while icc < count(2)
    icc = icc + 1;
    is = solve(ycc(icc), x);
    if is <= interval(1) || is >= interval(2)
    else
       ic = ic + 1; 
    end
end



x = -3 : 0.01 : 5;
EpsilonTolerance = 10E-05;
y1 = f(x);

plot(x, y1, 'r'), hold on, grid on;
xlabel('no units')
ylabel('no units') 
plottools


Iter = 0;
EpsilonCalcu = inf;
xprev = inf;
totalIter = 0;
xiplus1 = -1.5;
y = 1;
yd = -1;
it = 0;

while it < ic
    while y * yd > 0
        xiplus1 = xi + i*dx;
        i = i + 1 ;
        y = fprime(xi);
        yd = fprime(xiplus1);
        
    end
    
    xi = xiplus1;
    disp(xi +" "+ "xi")
    while EpsilonCalcu > EpsilonTolerance
        if Iter > 0
            EpsilonCalcu = abs(1 - (xprev/xi))*100;
            disp(EpsilonCalcu+" " + "epsilon");
        end
        
        xprev = xi;
        y = f(xi);
        disp(y+" " + "fx");
        yprime = fprime(xi);
        disp(yprime+" " + "f'x");
        
        plot(xi, y,'*');
        pause();
        
        xiplus1 = xi - (y/yprime)*0.7;
        xi = xiplus1;
        disp(xi+" " + "x");
        Iter = Iter + 1;
        if EpsilonCalcu < EpsilonTolerance
            disp(xi);
        end
        totalIter = totalIter + 1;
        
    end
    
    Iter = 0;
    EpsilonCalcu = 1;
    xiplus1 = xi + 0.8;
    y = fprime(xi);
    yd = fprime(xiplus1);
    i = 1;
    dx = 0.8;
    it = it +1;
    
end
