from django.shortcuts import render

def wordinput(request):
    return render(request, "wordinput.html")

def about(request):
    return render(request, "about.html")

def result(request):
    full = request.GET['fulltext']
    strlength = len(full)
    words = full.split()
    words_dic = {}

    for word in words:
        if word in words_dic:
            words_dic[word] += 1
        else:
            words_dic[word] = 1
    return render(request, 'result.html', {'full': full,
                                           'strlength': strlength,
                                           'cnt': len(words),
                                           'dic': words_dic.items()})



