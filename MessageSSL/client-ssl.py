import socket, ssl
import threading

HOST, PORT = 'localhost', 4443

def send_conn_input(conn):
    while True:
        text = input()
        conn.write(text.encode())

def get_conn_input(conn):
    while True:
        text = conn.recv()
        if text:
            print("server << " + text.decode())

def handle(conn):
    conn.write(b'GET / HTTP/1.1\n\r')
    conn.write(b'Host: www.google.com\n\r\n\r')
    print(conn.recv().decode())

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    conn = ssl.wrap_socket(sock, cert_reqs=ssl.CERT_REQUIRED, ca_certs='./cert.pem')

    try:
        conn.connect((HOST, PORT))
        # handle(conn)
        t = threading.Thread(name='send_input', args=(conn,), target=send_conn_input)
        t.start()
        t2 = threading.Thread(name='get_input', args=(conn,), target=get_conn_input)
        t2.start()
        while True:
            continue

    finally:
        conn.close()

if __name__ == '__main__':
    main()
