close all; clc; clear *;


fileO=load('original.mat');
x=fileO.x;
y=fileO.y;

%%% Round to 3 decimal places so we process less points in the whole array,
%%% so this data then will be accurate within half of a milimeter. 
xo=round(x,3); 
yo=y;
figure(1)
plot(xo,yo)

fileR=load('redesign.mat');
xr=fileR.x;
yr=fileR.y;
figure(2)
plot(xr,yr)


%%% Get evenly spaced data in order to easily find center of mass.
i=2;
tam=size(xo,2);
while 1
    %%% Matlab doesn't update the value on each loop iteration so we use
    %%% this to break instead of a loop condition
    if i>tam-1
       break; 
    end
    %%% Find distance between preveious point and current point
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
        newX = xo(i-1)+.001; 
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
      tam=size(xo,2);
    end
 
 i=i+1;   
end

figure(3)
plot(xo,yo)


%%% For every x find all values. Take the highest value and add lowest value.
%%% Then divide by two, this finds the mean value of y for that point of x.
%%% This is for all x.

disp('big boop');
%%%Find Y Value
counter = 0;
sum = 0;
trashed = 0;

%%% Fix matlab's floating point problems with this fix command. (Truncates after 4th decimal.)
xo = xo.*1000;
for i = min(xo): 1 : max(xo)
    
    %%% again fix matlabs shit
    xIndexes = find(xo==i);
    maxY = max(yo(xIndexes));
    minY = min(yo(xIndexes));
    if(~isempty(xIndexes))
        sum = sum + ((maxY + minY)/2);
    else 
        trashed = trashed + 1;
    end

    %%% Keep track of how many averages we took
    counter = counter + 1;
end

%%% Find x value
yValue = sum/(1000*counter);
xValue = (min(xo) + max(xo))/2;
hold on;
plot(xValue, yValue, '+r', 'MarkerSize', 20);

