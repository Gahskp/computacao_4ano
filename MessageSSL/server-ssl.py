import socket, ssl
import threading

# HOST, PORT, CERT = 'example.com', 443, '/path/to/example.com.pem'
HOST, PORT, CERT = 'localhost', 4441, './server.pem'

def get_conn_input(conn):
    while True:
        text = conn.recv()
        if text:
            print("client << " + text.decode())

def send_conn_input(conn):
    while True:
        text = input()
        conn.write(text.encode())

def handle(conn):
    print(conn.recv())
    conn.write(b'HTTP/1.1 200 OK\n\n%s' % conn.getpeername()[0].encode())

def main():

    sock = socket.socket()
    sock.bind((HOST, PORT))
    sock.listen(5)
    context = ssl.create_default_context(ssl.Purpose.CLIENT_AUTH)
    context.load_cert_chain(certfile=CERT, password="199601")  # 1. key, 2. cert, 3. intermediates
    context.options |= ssl.OP_NO_TLSv1 | ssl.OP_NO_TLSv1_1  # optional
    context.set_ciphers('EECDH+AESGCM:EDH+AESGCM:AES256+EECDH:AES256+EDH')
    while True:
        conn = None
        ssock, addr = sock.accept()
        try:
            conn = context.wrap_socket(ssock, server_side=True)
            # handle(conn)
            t = threading.Thread(name='get_input', args=(conn,), target=get_conn_input)
            t.start()
            t2 = threading.Thread(name='send_input', args=(conn,), target=send_conn_input)
            t2.start()
            while True:
                continue
                #loop

        except ssl.SSLError as e:
            print(e)
        finally:
            if conn:
                conn.close()
if __name__ == '__main__':
    main()
