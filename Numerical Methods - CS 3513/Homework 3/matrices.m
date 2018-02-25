%Student names:
%-Michael McQuade A01677104
%-Josh McMahan A01677115
%-José Ramón Luna Rosales A01337885
%-Vincent Vargas Villegas A01335644


close all; clc; clear all;

Ans = 1;

MenuString = ['(0) Invert a matrix\n'...
    '(1) Solve a system by providing a matrix \n'...
    'Select an option:  '];

while ( true ) %% Ask if we're solving normal matrix or an inverse matrix
    A= input(MenuString, 's');
    Ans = str2double(A);
    if (Ans == 1 || Ans == 0)
        break;
    end
    disp([A, ' is not a valid option']) %% User entered an invalid option, return to top of loop
end

validMatrix = false;
while (~validMatrix )
    Ma= input ('Provide an n x n matrix: '); %% must be in matlab's matrix form
    if (size(Ma, 1) ~= size(Ma, 2))
            validMatrix = false;
            disp('Matrix must have square dimensions e.g. 2x2, 3x3');
        else
            validMatrix = true;
    end
    if(Ans == 1)
        Mb= input ('Provide the n x 1 solutions vector: ');%%form [a;b;c]
        if (size(Ma, 1) ~= size(Mb,1)) %% ensures that the solution matrix has the same amount of rows as input matrix
            validMatrix = false;
            disp('Solution vector must have the same amount of rows as the input matrix');
        end
    end 
end

if (Ans == 1) %% user selection is normal matrix

    R=[Ma Mb]; % combined matrix with solutions
    disp(R) % print the matrix

    for x=1:length(R(:,1)) % x for all the diagonal matrix they need to be 1
        if R(x,x)~=1 % if the main diagonal isnt 1
            R(x,:)= R(x,:)./R(x,x); % it divide itself under itself to convert in 1
            disp(R)
        end
        for ny=1:length(R(:,1)) % x for all the numbers that are not in the main diagonal 
            if ny~=x  % it detects what is in the main diagonal and what not
              R(ny,:)=-R(ny,x).*R(x,:)+R(ny,:); % to convert all out of the main diagonal in 0
              disp(R)
            end 
        end  
    end

    Check= rref([Ma Mb]); % check of the gauss jordan with a matlab method
    disp('MATLABs result is: ' );
    disp(Check);% this displays the check
    disp('Our result is: ');
    disp(R);

end

if( Ans==0 ) %% user selection is to invert matrix
    I = eye(size(Ma));
    R = [Ma I]
    columns = size(R,1);
    for x=1:length(R(:,1)) % x for all the diagonal matrix they need to be 1
        if R(x,x)~=1 % if the main diagonal isnt 1
            R(x,:)= R(x,:)./R(x,x); % it divide itself under itself to convert in 1
            disp(R(:,(columns)+1:columns*2))
        end
        for ny=1:length(R(:,1)) % x for all the numbers taht are not in the main diagonal 
            if ny~=x  % it detects what is in the main diagonal and what not
              R(ny,:)=-R(ny,x).*R(x,:)+R(ny,:); % to convert all out of the main diagonal in 0
              disp(R(:,(columns)+1:columns*2))
            end 
        end  
    end
    disp('MATLABs result: ');
    disp(inv(Ma));
    disp('Our result: ');
    disp(R(:,(columns)+1:columns*2))
end
