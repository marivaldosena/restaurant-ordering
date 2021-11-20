FROM localstack/localstack:0.12.17

RUN pip install awscli-local

COPY localstack /opt/bootstrap

RUN chmod +x /opt/bootstrap/cli/boot-local-env.sh && sed -i -e 's/\r$//' /opt/bootstrap/cli/boot-local-env.sh

RUN chmod +x /opt/bootstrap/cli/bootstrap.sh && sed -i -e 's/\r$//' /opt/bootstrap/cli/bootstrap.sh

ENTRYPOINT ["/opt/bootstrap/cli/bootstrap.sh"]