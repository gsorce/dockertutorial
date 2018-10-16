# gsorce/dockertutorial-matlab-installation
# 
# Create an image with a matlab embedded.
#
# These expect you to define some local information:
# - `MATLAB_WORKDIR` is optional path on the Docker host to receive Matlab logs, perhaps `~/matlab-logs`.
# - `MATLAB_MAC_ADDRESS` is the MAC address associated with your own Matlab License, of the form `00:00:00:00:00:00`.
#
# Thanks to Michael Perry at Stanford for info, inspiration, starter code!
#

# For the image OS layer, use a supported version of Linux, 
# See the system requirements <https://www.mathworks.com/support/sysreq.html here>.
# 
# I selected ubunto 18.04 LTS from https://hub.docker.com/_/ubuntu/
FROM ubuntu:18.04

LABEL maintainer="Giuseppe Sorce <giuseppe.sorce@gmail.com>"

# Matlab dependencies
ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update && apt-get install -y \
   libpng-dev libfreetype6-dev \
   libblas-dev liblapack-dev gfortran build-essential xorg

# The image has been created from my local installation of MATLAB in /home/gsorce/DiscoD/devel/linux/MATLAB/R2018b
# This installation will be copied in the folder /app 
# so that the image will contain the MATLAB installation in the folder /app:
WORKDIR /app
ADD MATLAB_R2018b.tar.gz /app

# run the container like a matlab executable 
ENV PATH="/app/MATLAB/R2018b/bin:${PATH}"
ENTRYPOINT ["matlab", "-logfile /var/matlab/matlab.log"]

# default to matlab help
CMD ["-h"]

