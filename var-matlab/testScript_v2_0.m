function testScript_v2_0()
disp hello;
% MATLAB_INPUTFILE='/var/matlab/inputData.csv';
% MATLAB_OUTPUTFILE='/var/matlab/outputData.csv';
inputFileName = getenv('MATLAB_INPUTFILE');
outputFileName = getenv('MATLAB_OUTPUTFILE');
M = csvread(inputFileName);
disp(M);
C = M.^2;
disp(C);
csvwrite(outputFileName,C);
end

