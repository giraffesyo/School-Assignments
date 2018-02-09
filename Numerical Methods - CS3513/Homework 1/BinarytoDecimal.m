%just doing this to make sure we don't have anything left over from
%previous scripts
clear all;
close all;
clc;

%Take input in as string, so we don't accidentally use any variables or do
%weird stuff
exitstring = 'Bad Input, program exiting: please enter an integer';
inputstring = input('Enter a binary integer: ','s');

%convert to a double and check if what we have stored is a number or not,
%if the conversion failed, we get NaN and we exit the program
usernum = str2double(inputstring);
if isnan(usernum) || fix(usernum) ~= usernum
  disp(exitstring)
  return;
end

%count how many characters are in the string that we converted the number
%into
i = numel(inputstring);
failed = false;

%loop through every digit in our number, and make sure that it is either a
%0 or a 1, if it isn't, the user failed to give us good input and the
%program will exit. 
while ( i > 0)
    current = str2double(inputstring(i));
    if ( current ~= 0 && current ~= 1)
        failed = true;
    end
    i = i - 1;
end
if (failed)
    disp(exitstring);
    return;
end

%Simply go through the digits in the number again, (backwards), and this
%time we do the math currentDigit * 2^DigitIndex + previousResults in order
%to get our final result
i = numel(inputstring);     
sum = 0;
power = 0;
while ( i > 0 )
    sum = sum + str2double(inputstring(i)) *2^power;
    i = i - 1;
    power = power + 1;
end

%Concatenate the final result into a presentable answer and display it. 
ans = [ 'The binary number ' inputstring ' ' 'in decimal is ' num2str(sum)];
disp(ans);

