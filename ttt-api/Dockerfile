# Use an official Python runtime as the base image
FROM python:3.8-alpine

# Copy your project files into the container
COPY requirements.txt ./

# Install any project-specific dependencies
RUN pip install -r requirements.txt

# Bundle app source
COPY . .

EXPOSE 8083

# Specify the command to run your project
CMD [ "flask", "run","--host","0.0.0.0","--port","8083"]