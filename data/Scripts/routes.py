from bs4 import BeautifulSoup
import requests
import re

with open('trains.txt', "r") as f:
    l = list(f.readlines())

i = 710
for train in l[710:]:
    url = train[train.find('http'):-1]
    r = requests.get(url)
    html = r.text
    soup = BeautifulSoup(html, 'html.parser')
    rows = soup.find_all('table')[1].find_all('tr')
    file_name = url.split('/')[-2] + '(' + url.split('/')[-1] + ').txt'
    with open(file_name, "w") as f:
        for row in rows:
            columns = row.find_all('td')
            l = []
            for col in columns:
                l.append(col.get_text())
            code = re.findall('\((.*?)\)', l[1])
            if(len(code) == 0):
                code = ['Station Code']
            f.write('{:^6}|{:^40}|{:^20}|{:^15}|{:^15}|{:^15}|{:^20}|{:^10}\n'.format(l[0], l[1].split('(')[0], code[0], l[2], l[3], l[4], l[5], l[6]))
            print ('{:^6}|{:^40}|{:^20}|{:^15}|{:^15}|{:^15}|{:^20}|{:^10}\n'.format(l[0], l[1].split('(')[0], code[0], l[2], l[3], l[4], l[5], l[6]))
    print i
    i += 1
