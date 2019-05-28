const cheerio = require('cheerio');
const request = require('request');

const url = 'https://www.infoq.com/br/java/news';

const requestCallBack = (error, response, body) => {
    const data = parseBody(body);
    console.log(data);
}

const getData = (url) => {
    request(url, requestCallBack);
}


const parseBody = (body) => {
    const $  = cheerio.load(body);
    const data = [];
    $(".card__data").each((i,element) => {
        const cardData = cheerio.load(element);
        let title = cardData(".card__title > a").text().replace(/\n/g,'').trim();   
        let description = cardData(".card__excerpt").text().replace(/\n/g,'').trim();
        let authors = cardData(".card__authors > span > a").text();
        data.push({title, description, authors});
    });
    return data;
}


getData(url);

