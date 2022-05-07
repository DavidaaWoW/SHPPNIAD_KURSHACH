from os import write
import re
import requests
from bs4 import BeautifulSoup
import csv


URL = 'https://sushiwok.ru/msk/menu/'
HEADERS = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 YaBrowser/21.6.4.693 Yowser/2.5 Safari/537.36'}
HOST = 'https://sushiwok.ru'
productss = []


def get_html(url, params=None):
    r = requests.get(url, headers=HEADERS, params=params)
    return r


def get_content(html):
    soup = BeautifulSoup(html, 'html.parser')
    items = soup.find_all(
        'a', class_='menu-item')
    counter = 0
    counter3 = 1
    for item in items:
        counter += 1
        category_link = HOST + item.get('href')
        category_img = HOST + item.find('img').get('src')
        category_title = item.find('span').get_text()
        # productss.append({
        #     'id': counter,
        #     'name': category_title,
        #     'image_link': category_img,
        #     'subsequence_number': counter
        # })
        html2 = get_html(category_link)
        soup2 = BeautifulSoup(html2.text, 'html.parser')
        products = soup2.find_all('div', class_='card--grid')
        print(category_title)
        counter2 = 1
        for product in products:
            try:
                product_price = product.find('div', class_='card__price__and__buybutton').find(
                    'span', class_='card__price__current--is-action').find('span').get_text()
            except:
                try:
                    product_price = product.find('div', class_='card__price__and__buybutton').find(
                        'span', class_='card__price__current').find('span').get_text()
                except:
                    continue
            product_name = product.find('p', class_='card__name').get_text()
            product_subsequence_number = counter2
            product_img_pre = product.find(
                'span', class_='card__image').find('img').get('srcset')
            product_img = HOST + "/" + ((re.search("img\/(\w*)\/500",
                                                   product_img_pre))[0])[:-4]
            product_description = product.find(
                'span', class_='card__ingredients').get_text()
            print(product_name)
            productss.append({
                'id': counter3,
                'name': product_name,
                'subsequence_number': counter2,
                'category_id': counter,
                'image_link': product_img,
                'description': product_description,
                'price': product_price
            })
            counter3 += 1
            counter2 += 1


def save_file(items, path):
    with open(path, 'a', newline='', encoding='utf-16') as file:
        writer = csv.writer(file, delimiter=',')
        # writer.writerow(["id", "name", "image_link", "subsequence_number"])
        # for item in items:
        #     writer.writerow([item['id'], item['name'],
        #                     item['image_link'], item['subsequence_number']])
        writer.writerow(["id", "name", "subsequence_number",
                        "category_id", "image_link", "description", "price"])
        for item in items:
            writer.writerow([item['id'], item['name'], item['subsequence_number'],
                            item['category_id'], item['image_link'], item['description'], item["price"]])


def parse():
    html = get_html(URL)
    if html.status_code == 200:
        get_content(html.text)
        save_file(productss, 'dishes.csv')
        print('Success!')
    else:
        print('Error')


parse()
