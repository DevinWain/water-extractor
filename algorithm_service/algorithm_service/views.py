from urllib import response
from django.http import HttpResponse
from django.http import JsonResponse
from .utils.preprocess import resize_, otsu_1d_
from .constant import ROOT_PATH, ORG_PATH, SAVE_PATH


def hello(request):
    response = JsonResponse({'url': 'www.baidu.com'})
    return response

def resize(request):    
    url = request.GET.get('url')
    resize_(url)
    response = JsonResponse({'url': "processed_" + url, 'code': 1})
    return response

def otsu_1d(request):
    url = request.GET.get('url')
    otsu_1d_(url)
    response = JsonResponse({'url': "1dotsu_" + url, 'code': 1})
    return response