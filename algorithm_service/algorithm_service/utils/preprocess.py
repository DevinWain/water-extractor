import numpy as np
from skimage import transform, exposure, filters, morphology, io, util
from ..constant import ROOT_PATH, ORG_PATH, SAVE_PATH

def resize_(url, size=512, replace = True, is_print = True, is_save = True):
        img = io.imread(ROOT_PATH + ORG_PATH + url, as_gray = True)
        after_resize = transform.resize(img, (size, size), anti_aliasing=True)
        if is_print:
            print("after resizing: ")
            print(after_resize.shape)
        if is_save:
            print(SAVE_PATH + "processed_" + url)
            io.imsave(SAVE_PATH + "processed_" + url, after_resize)
        # if replace:
        #     img = after_resize

def otsu_1d_(url, replace = True, is_save = True):
        img = io.imread(SAVE_PATH + "processed_" +  url, as_gray = True)
        thresh = filters.threshold_otsu(img)
        # print(thresh)
        binary = img > thresh
        if is_save:
            print(SAVE_PATH + "1dotsu_" + url)
            io.imsave(SAVE_PATH + "1dotsu_" + url, binary)
        # if replace:
        #     img = binary
        

