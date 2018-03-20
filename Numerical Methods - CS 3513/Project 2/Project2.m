clc,close all;

file=load('satuSignal.mat');
x=file.tsat;
y=file.fsat;
xC=x;
yC=y;
i=3;

figure(1)
plot(x,y)
%%% in order to have evenly spaced values in our provided data
while x(i)<1
    dist = x(i)- x(i-1);
    %%% Use newtons divided quadratic difference to evenly space data
    %%% Space between points (0.001...)
    if (dist>0.0012) 
      newX= x(i-1)+.001;
      b0=y(i-2);
      b1=(y(i-1)-b0)/(x(i-1)-x(i-2));
      b2=((y(i)-y(i-1))/(x(i)-x(i-1))-b1)/(x(i)-x(i-2));
      newY= b0+b1*(newX-x(i-2))+b2*(newX-x(i-2))*(newX-x(i-1));
      %%% we cannot have values above .5
      if newY>.5 
      newY=.5;
      end
      if newY<-.5
      newY=-.5;
      end
      %%% Insert new point to array. 
      x=[x(1:i-1) newX x(i:end)];
      y=[y(1:i-1) newY y(i:end)];
    end
     i=i+1;   
end

i=1;
while x(i)<1
    if abs(y(i))>=.5
        k=0;
        j=0;
        %%% K is end of saturation
        while abs(y(i+k))>=.5
            k=k+1;
        end
           
        %%% Continue moving left through data set (by using j=j-1)
        %%until the sign of y(i+j)*y(i) changes. This validates that the
        %%point y(i+j) is the data point close to zero .
        while y(i+j)*y(i)>0
        j=j-1;
        end
        p1=i+j;%p1 and p2 are the indexes, (not the values)
        j=0;
        %%% Continue moving right through data set until the sign changes,
        %%% just as above (but right)
        while y(i+k+j-1)*y(i+k)>0
        j=j+1;
        end
        p2=i+k+j;
        per=(x(p2)-x(p1))*2;
        f=2*pi/per;
       
        %%% We are finding the proportion between the first saturation point and the
        %%% nearest left root over the entire period.. Then we applied this
        %%% proportion to the full period (2pi) and then made a relation to
        %%% the sine function. Then we scaled the saturation point over
        %%% this factor. This allowed us to find the amplitude of the sine
        %%% function using A = .5/B where B = sin(2*pi*(x(i)-x(p1))/per)
        A1=y(i)/sin(2*pi*(x(i)-x(p1))/per);
        A2=y(i)/sin(2*pi*(x(p2)-x(i+k))/per);
        %%% We apply the above mentioned method to find the
        %%% proporitions from the left and the right, in order to find the
        %%% mean. This is because the signal is not perfectly symmetrical.
        A=(A1+A2)/2;

         %%% Go from p1 to p2 and change the values to the results of the
         %%% following function: y = A*sin(Fx) where A is amplitude and F is
         %%% frequency. The subtraction of x(p1) is to displace the sine
         %%% function to start it at a value of 0
         j=p1-i;
         while(i+j<p2)
            y(i+j)=A*sin(f*(x(i+j)-x(p1)));
            j=j+1;
        end
        i=p2;
    else
       i=i+1;
    end 
end   
figure(2)
plot(x,y)


%%%Problem 1 and Problem 2: Find derivative to left when derivative is going close to
%%%zero will be the crest. (same for right) 
%%% Make starting point 0.5, make a counter of 4, go to the left and record
%%% each time derivative is at zero then continue left. If function value at that point is negative then its a valley, if its positive its a crest
%%% Same for right. 

i = floor(size(x,2)/2); %% start at half of the array
counter = 0;
Error = .001;
leftCrests = [];
leftValleys = [];

%%% Go to left and find valleys and crests
while counter < 4
    
    %%% Take forward and centered derivative then find the one that is
    %%% smaller, we do this because the method makes both flat valleys/crests and
    %%% pointy (triangle shaped) valleys/crests. The derivative of these triangular shaped
    %%% valleys/crests will never equal zero because they always have a
    %%% slope. Thus we need the centered difference for them.
    dyForward = (y(i+1)-y(i))/(2*(x(i+1))-x(i));
    dyCentered= (y(i+1)-y(i-1))/(2*(x(i+1))-x(i-1));
    dyFinal = min(abs(dyForward), abs(dyCentered));
    
    if abs(dyFinal) < Error
        if y(i) > 0 
           leftCrests = [leftCrests; [x(i), y(i)]];
        elseif y(i) < 0
           leftValleys = [leftValleys; [x(i), y(i)]];
        end
        counter = counter + 1;
        i = i - floor(size(x, 2)*.005); %%% Skip .5% of array size
    else
        i = i - 1;
    end
    
    %%% make sure we never crash because we ran out of data
    if( i < 5)
       break; 
    end
end
disp("2 Crests to the left of 0.5: ")
disp(leftCrests)
disp("2 Valleys to the left of 0.5: ")
disp(leftValleys)



i = floor(size(x,2)/2); %% start at half of the array
counter = 0;
Error = .001;
rightCrests = [];
rightValleys = [];
while ( counter < 4 )
    %%% Right is same as above but positive
    dyForward = (y(i+1)-y(i))/(2*(x(i+1))-x(i));
    dyCentered= (y(i+1)-y(i-1))/(2*(x(i+1))-x(i-1));
    dyFinal = min(abs(dyForward), abs(dyCentered));
    
    if abs(dyFinal) < Error
        if y(i) > 0 
           rightCrests = [rightCrests; [x(i), y(i)]];
        elseif y(i) < 0
           rightValleys = [rightValleys; [x(i), y(i)]];
        end
        counter = counter + 1;
        i = i + floor(size(x, 2)*.005); %%% Skip .5% of array size
    else
        i = i + 1;
    end
    
    %%% make sure we never crash because we ran out of data
    if( i < 5)
       break; 
    end
end
disp("2 Crests to the right of 0.5:")
disp(rightCrests)
disp("2 Valleys to the right of 0.5:")
disp(rightValleys)

%%% Problem 3: Take second derivative of functions where they its zero.

%%% Problem 4: 

disp(strcat("Time signal is above 0.5: ", num2str(size(find(y>.5),2)* .001), " seconds"))
%%% Problem 5:
disp(strcat("Time signal is below -0.8: ", num2str(size(find(y<-.8),2)* .001), " seconds"))
%%% Probme 6: 
disp(strcat("Time signal is below 0.1: ", num2str(size(find(y<.1),2)* .001), " seconds"))


