


# gsorce/matlab-mcr-java



# TODO: vedi se serve portarmi dentro anche ubuntu
# For the image OS layer, use a supported version of Linux, 
# See the system requirements <https://www.mathworks.com/support/sysreq.html here>.
# 
# I selected ubunto 18.04 LTS from https://hub.docker.com/_/ubuntu/
# FROM ubuntu:18.04

# 	TODO: usa gsorce@gsorce-LIFEBOOK-A556:~/DiscoD/devel/linux/MATLAB/R2018b$ java -version
# 	java version "1.8.0_111"
# 	Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
# 	Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
# 	al posto di 
# FROM openjdk:8u151-jre 
#
#	Oppure:
# ——————————
# Install Java.
# ——————————
#  RUN \
#   echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
#   add-apt-repository -y ppa:webupd8team/java && \
#   apt-get update && \
#   apt-get install -y oracle-java8-installer && \
#   rm -rf /var/lib/apt/lists/* && \
#   rm -rf /var/cache/oracle-jdk8-installer
# Define commonly used JAVA_HOME variable
# ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

FROM openjdk:8u151-jre
 
LABEL maintainer="Giuseppe Sorce <giuseppe.sorce@gmail.com>"

ADD matlab.txt /mcr-install/matlab.txt

# TODO: verifica se servono anche queste
# Matlab dependencies
# ENV DEBIAN_FRONTEND noninteractive
# RUN apt-get update && apt-get install -y \
#    libpng-dev libfreetype6-dev \
#    libblas-dev liblapack-dev gfortran build-essential xorg


ENV DEBIAN_FRONTEND noninteractive
RUN apt-get update && \
	apt-get install -y curl wget unzip xorg

ARG WGET_PROXY_USER
ARG WGET_PROXY_PASSWORD 
ARG WGET_HTTP_PROXY

# Install MATLAB runtime 
RUN 	cd /mcr-install && \ 
	wget -e use_proxy=yes -e http_proxy=$WGET_HTTP_PROXY --proxy-user=$WGET_PROXY_USER --proxy-password=$WGET_PROXY_PASSWORD -nv http://www.mathworks.com/supportfiles/downloads/R2016b/deployment_files/R2016b/installers/glnxa64/MCR_R2016b_glnxa64_installer.zip && \ 
	unzip MCR_R2016b_glnxa64_installer.zip && \ 
	mkdir /opt/mcr && \
	./install -mode silent -agreeToLicense yes -destinationFolder "/opt/mcr" -inputFile /mcr-install/matlab.txt && \
	cd / && \
	rm -rf mcr-install
ENV LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/opt/mcr/v91/runtime/glnxa64:/opt/mcr/v91/bin/glnxa64:/opt/mcr/v91/sys/os/glnxa64:/opt/mcr/v91/sys/java/jre/glnxa64/jre/lib/amd64/native_threads:/opt/mcr/v91/sys/java/jre/glnxa64/jre/lib/amd64/server:/opt/mcr/v91/sys/java/jre/glnxa64/jre/lib/amd64 
ENV XAPPLRESDIR=/opt/mcr/v91/X11/app-defaults 
ENV MCR_CACHE_VERBOSE=true 
ENV MCR_CACHE_ROOT=/tmp 


# Adding the testScript from my local package in /var/matlab
# This installation will be copied in the folder /app 
# so that the image will contain the testScript installation in the folder /app/testScript_v2_0/for_testing
WORKDIR /app
ADD testScript_v2_0.tar.gz /app


###################################################################################
# gsorce@gsorce-LIFEBOOK-A556:~/DiscoD/devel/linux/matlab-mcr-java$ sudo docker build --build-arg http_proxy="http://sorce:ewpt2RT2SOFIA@192.168.10.1:3128" --build-arg WGET_HTTP_PROXY="http://192.168.10.1:3128" --build-arg WGET_PROXY_USER="sorce" --build-arg WGET_PROXY_PASSWORD="ewpt2SF2TACCI" -t matlab-mcr-java .

# $ sudo docker run -ti -v /var/matlab:/var/matlab -e MATLAB_INPUTFILE='/var/matlab/inputData.csv' -e MATLAB_OUTPUTFILE='/var/matlab/outputData.csv' matlab-mcr-java /bin/bash -c "cd /app/testScript_v2_0/for_testing; java -classpath .:/opt/mcr/v91/toolbox/javabuilder/jar/javabuilder.jar:./testScript_v2_0.jar getmagic"


###################################################################################


