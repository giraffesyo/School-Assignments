%%% Michael McQuade, Joshua Ben McMahan, Jose Ramon Luna, Vincent Vargas
%%% A01677104, A01677115, A01337885, A01335644

%%Original
close all; clc; clear *;


fileO=load('original.mat');
xo=fileO.x;
yo=fileO.y;

displacement = 0;
xo = xo + displacement;
%%%yo = yo + 5;

%%% Round to 3 decimal places so we process less points in the whole array,
%%% so this data then will be accurate within half of a milimeter. 
xo=round(xo,3); 


%%% Get evenly spaced data in order to easily find center of mass.
i=2;
arraySize=size(xo,2);
while 1
    %%% Matlab doesn't update the value on each loop iteration so we use
    %%% this to break instead of a loop condition
    if i>arraySize-1
       break; 
    end
    %%% Find distance between previous point and current point
    dist = xo(i)- xo(i-1);
    if abs(dist) > 0.0011
      if dist < 0
        %%% When we're going to the left we need to add the x value to be
        %%% the next value to the left of the previous value. 
        newX = xo(i-1) - .001;
      else
        %%% When we're going to the right we need to add the x value to be
        %%% the next value to the right
        %%% Where is previous x plus the step we're making (.001)
        newX = xo(i-1) + .001; 
      end

      %%% Use Newton's divided difference for quadratic in order to
      %%% calculate the new y. 
      b0=yo(i-1);
      b1=(yo(i)-b0)/(xo(i)-xo(i-1));
      b2=((yo(i+1)-yo(i))/(xo(i+1)-xo(i))-b1)/(xo(i+1)-xo(i-1));
      newY= b0+b1*(newX-xo(i-1))+b2*(newX-xo(i-1))*(newX-xo(i));
      
      xo=[xo(1:i-1) newX xo(i:end)];
      yo=[yo(1:i-1) newY yo(i:end)];
      
      %%% We must adjust the size so we don't stop short
      arraySize=size(xo,2);
    end
 
 i=i+1;   
end


%%% For every x find all values. Take the highest value and add lowest value.
%%% Then divide by two, this finds the mean value of y for that point of x.
%%% This is for all x.


%%%Find Y Value of center of mass for  Original X 
counter=0;
sumy=0;
sumx=0;
xo = 1000.*xo;
d0 = 0;

%%% According to: 
%%% https://www.khanacademy.org/science/physics/linear-momentum/center-of-mass/v/center-of-mass-equation

for i=min(xo):max(xo) %%%i is set to the minimum value of the matrix and proceeds to the right. 
  %%%finds the points where the x values are the value of i. 
  %%% The reason for this is because of matlab floating point comparison
  %%% problems
  index=find((xo<i+.5) & (xo>i-.5));
  ymax=max(yo(index));
  ymin=min(yo(index));
  sumy=sumy+(ymax+ymin)/2;
  %%% Sum x's for use in xCenter of mass,
  %%% Instead of using min(x)+max(x))/2, which would only work if the
  %%% object was known to be symmetrical, we use ymax and ymin of the
  %%% current index, multiplied by the current x value (i), this will give
  %%% us the weighted sum of our x's, which we will later use as the center
  %%% of mass (this value divided by the number of x values
  sumx=sumx+i*abs(ymax-ymin); %%% numerator
  d0=d0+abs(ymax-ymin); %%%denominator
  
  if isempty(index)
    disp('fail');
  end
  %%% keep track of how many averages we took
  counter=counter+1;
end

xo = xo./1000;
yCenter=sumy/counter;
%%% Find x value
xCenter=sumx/(1000*d0);

figure(1);
plot(xo,yo); %%% plot evenly spaced heart

hold on;
plot(xCenter, yCenter, '+r', 'MarkerSize', 20);
title('Center of Mass for Original');
xlabel('Width - Centimeters [cm]');
ylabel('Height - Centimeters [cm]');
set(gcf, 'Units', 'Normalized', 'OuterPosition', [0, 0.5, 0.5, 0.5]);



%% Redesign
fileR=load('redesign.mat');
xr=fileR.x;
yr=fileR.y;

xr= xr + displacement;
%%%yr = yr+5;
%%figure(2)
%%plot(xr,yr)


%%% Round to 3 decimal places so we process less points in the whole array,
%%% so this data then will be accurate within half of a milimeter. 
xr=round(xr,3); 


%%% Get evenly spaced data in order to easily find center of mass.
i=2;
arraySize=size(xr,2);
while 1
    %%% Matlab doesn't update the value on each loop iteration so we use
    %%% this to break instead of a loop condition
    if i>arraySize-1
       break; 
    end
    %%% Find distance between preveious point and current point
    dist = xr(i) - xr(i-1);
    if abs(dist) > 0.0011
      if dist < 0
        %%% When we're going to the left we need to add the x value to be
        %%% the next value to the left of the previous value. 
        newX = xr(i-1) - .001;
      else
        %%% When we're going to the right we need to add the x value to be
        %%% the next value to the right
        %%% Where is previous x plus the step we're making (.001)
        newX = xr(i-1) + .001; 
      end

      %%% Use Newton's divided difference for quadratic in order to
      %%% calculate the new y. 
      b0=yr(i-1);
      b1=(yr(i)-b0)/(xr(i)-xr(i-1));
      b2=((yr(i+1)-yr(i))/(xr(i+1)-xr(i))-b1)/(xr(i+1)-xr(i-1));
      newY= b0+b1*(newX-xr(i-1))+b2*(newX-xr(i-1))*(newX-xr(i));
      
      xr=[xr(1:i-1) newX xr(i:end)];
      yr=[yr(1:i-1) newY yr(i:end)];
      
      %%% We must adjust the size so we don't stop short
      arraySize=size(xr,2);
    end
 
 i=i+1;   
end



%%% For every x find all values. Take the highest value and add lowest value.
%%% Then divide by two, this finds the mean value of y for that point of x.
%%% This is for all x.

%%%Find Y Value
counter=0;
sumy=0;
sumx=0;
xr = 1000.*xr;
d0 = 0;
for i=min(xr):max(xr)
  index=find((xr<i+.5) & (xr>i-.5));
  ymax=max(yr(index));
  ymin=min(yr(index));
  sumy=sumy+(ymax+ymin)/2;
  sumx=sumx+i*abs(ymax-ymin);
  d0=d0+abs(ymax-ymin);  
  
  if isempty(index)
    disp('fail');
  end
  %%% keep track of how many averages we took
  counter=counter+1;
end

xr = xr./1000;
yrCenter=sumy/counter;
%%% Find x value
%%xrCenter=sumx/(1000*counter);
xrCenter=sumx/(1000*d0);


figure(2);
plot(xr,yr);
hold on;
plot(xrCenter, yrCenter, '+r', 'MarkerSize', 20);
title('Center of Mass for Redesign');
xlabel('Width - Centimeters [cm]');
ylabel('Height - Centimeters [cm]');
% Make figure fit in upper right quadrant..
set(gcf, 'Units', 'Normalized', 'OuterPosition', [0.5, 0.5, 0.5, 0.5]);

distance = sqrt((xrCenter-xCenter)^2 + (yrCenter - yCenter)^2);

answer = round(distance,3);

disp(strcat("The cookie moved ", num2str(answer), " centimeters from its original position"));

if(distance > 0.5)
    disp("Chinacorp is at fault.");
else 
    disp("The wildbeast is at fault.");
end
