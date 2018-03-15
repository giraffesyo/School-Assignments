close all; clear *; clc;

x1 = 0.0161;
x2 = 2.051;
x3 = 0.5;
x4 = -2;
x5 = 3;

figureCount = 1;

Xs = [ x1 x2 x3 x4 x5 ]
for ( K = 1:size(Xs,2))


    syms x;


    funF = x^3 - (31/10)*x^2 + (1/10)*x + (21/5);
    funDF = 3*x^2 - 2*(31/10)*x + (1/10);

    x = Xs(K);
    f = subs(funF);
    df = subs(funDF);

    Xnext = x - (f/df);
    tolerance = 0.00000001;
    iterations = 100;
    i = 0;
    Xoriginal = x;
    solutions = [];
    numberOfSolutions = 0;
    flag = 0;
    originalLeft = 0;
    originalRight = 0;
    left = 0;
    right = 0;
    
    originalF = funF;
    originalDF = funDF;
    title('Newton Raphson Root Finding');
    xlabel('Iteration number (i)');
    ylabel('Value of Xi');
    
    
    while ( i <= iterations )
        if ( left == 1 || right == 1)
           flag = 0;
           right = 0;
           left = 0;
        end

        if (numberOfSolutions > 0 && flag == 0)             %% Flag controls that we only enter this block when we need to factor out a root
            flag = 1;
            syms x;
            currentSolution = solutions(end);
            funF = simplify(funF/(x - currentSolution));
            funDF = diff(funF);
            x = Xoriginal;
        end

        f = eval(subs(funF));
        df = eval(subs(funDF));
        if ( df == 0)
            df = tolerance;
        end

        ppd = f/df;
        Xnext = x - (ppd);
        Error = abs((Xnext - x)/Xnext);
        x = Xnext;

        if ( Error <= tolerance)
            if (x < Xoriginal ) %% we went left
                if (numberOfSolutions == 0)
                    originalLeft = 1;
                end
                left = 1;
                right = 0;
            else
                if ( x > Xoriginal ) %% we went right
                    if (numberOfSolutions == 0)
                        originalRight = 1;
                    end
                    right = 1;
                    left = 0;
                end
            end
            solutions = [solutions x]; %% solutions is equal to itself + next solution (x)
            numberOfSolutions=size(solutions,2); %% get size of solution set
            flag = 0;
            if( originalLeft == 1 && right == 1) 
                    %%%finish root finding
                break;
            else
                if ( originalRight == 1 && left == 1 )
                    %%%finish root finding
                    break;
                end

            end
        end
        i = i + 1;
        hold on
        stem(i, x)
    end
    if figureCount < size(Xs,2) %% make a figure for each value of X
        figureCount = figureCount + 1;
        figure;
    end
    
    leftSolutions = [];
    rightSolutions = [];
    
    %%% Build right solutions and left solutions matrix
    for  J = 1 : numberOfSolutions 
        if ( solutions(J) < Xoriginal)
            leftSolutions = [leftSolutions solutions(J)];
        else
            rightSolutions = [rightSolutions solutions(J)];
        end
    end
    
    leftSolution = max(leftSolutions);
    rightSolution = min(rightSolutions);
    if( ~isempty(leftSolution))  
        disp(strcat("Zero 1 found to the left of ", num2str(Xoriginal), " with value of ", num2str(leftSolution), " for function ", char(originalF))); 
    end
    if ( ~isempty(rightSolution))
        disp(strcat("Zero 2 found to the right of ", num2str(Xoriginal), " with value of ", num2str(rightSolution), " for function ", char(originalDF)));
    end
    
    disp('-------------------------------------');
end


