FROM ubuntu:latest
LABEL authors="heric"

ENTRYPOINT ["top", "-b"]