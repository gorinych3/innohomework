package ru.gorinych3.innohomework.homework.task7.part2;

/**
 * Создать генератор текстовых файлов, работающий по следующим правилам:
 * <p>
 * Предложение состоит из 1<=n1<=15 слов. В предложении после произвольных слов могут находиться запятые.
 * Слово состоит из 1<=n2<=15 латинских букв
 * Слова разделены одним пробелом
 * Предложение начинается с заглавной буквы
 * Предложение заканчивается (.|!|?)+" "
 * Текст состоит из абзацев. в одном абзаце 1<=n3<=20 предложений. В конце абзаца стоит разрыв строки и перенос каретки.
 * Есть массив слов 1<=n4<=1000. Есть вероятность probability вхождения одного из слов этого массива в следующее
 * предложение (1/probability).
 * Необходимо написать метод getFiles(String path, int n, int size, String[] words, int probability),
 * который создаст n файлов размером size в каталоге path. words - массив слов, probability - вероятность.
 */
public class Main {

    public static String[] arrWords = {"a", "able", "about", "accept", "according", "added", "addition", "additionally",
            "advance", "advantage", "adverse", "afloat", "after", "ago", "all", "allowed", "also", "among", "amount",
            "amounts", "an", "and", "another", "any", "apparently", "appear", "appears", "approach", "are", "as",
            "asked", "asks", "assertion", "assets", "assistant", "at", "atlantic", "audit", "aura", "awkward",
            "balances", "bank", "bankruptcy", "banks", "based", "battle", "be", "beautiful", "because", "been",
            "began", "being", "ben", "berzin", "big", "biggest", "bill", "billion", "billions", "bonds", "borrowed",
            "borrower", "borrowing", "both", "buildings", "bulk", "burned", "business", "businesses", "but", "buying",
            "by", "calling", "came", "campaign", "candidate", "capital", "captain", "carnell", "cash", "casino",
            "casinos", "challenge", "challenges", "chicago", "city", "claimed", "clinging", "clinton", "come",
            "coming", "commitment", "companies", "company", "completed", "complied", "concern", "condition",
            "consistently", "controls", "cost", "could", "courses", "cover", "credit", "creditworthiness", "crimes",
            "crisis", "curb", "data", "deal", "deals", "dealt", "debt", "debts", "decade", "decadelong", "decades",
            "deciding", "declaring", "decline", "declining", "defaulted", "demand", "department", "despite",
            "deutsche", "did", "difficulty", "dire", "disclosure", "disclosures", "displayed", "disposal", "djt",
            "do", "does", "dollars", "donald", "doral", "down", "dried", "due", "during", "eager", "earlier",
            "editors", "education", "enabled", "end", "endorsements", "entertainment", "enthusiasm", "entities",
            "even", "evidence", "example", "executive", "expensive", "explored", "extremely", "faces", "fact",
            "failing", "fair", "fame", "favor", "federal", "few", "file", "filed", "finances", "financial", "five",
            "foes", "for", "fordham", "foreclose", "former", "forms", "found", "four", "francisco", "fraught", "from",
            "fueled", "game", "gives", "global", "golf", "got", "government", "guarantee", "guaranteed", "had", "hall",
            "hand", "hanging", "has", "have", "he", "help", "heres", "hesitant", "him", "his", "holding", "holdings",
            "hotel", "huge", "hundreds", "i", "identify", "if", "illustrate", "im", "in", "include", "including",
            "income", "indicate", "institution", "institutions", "internal", "international", "into", "investigate",
            "investigated", "investigation", "investment", "investments", "irs", "is", "isnt", "issued", "it", "its",
            "itself", "james", "january", "july", "just", "justice", "keep", "ladder", "landed", "largest", "last",
            "laundering", "law", "laws", "least", "left", "legal", "legitimacy", "lend", "lender", "lenders", "lent",
            "less", "levers", "liabilities", "licensing", "like", "likely", "line", "liquidating", "little", "loan",
            "loans", "located", "long", "longheld", "longstanding", "look", "losses", "lucrative", "main",
            "mainstream", "manhattan", "many", "married", "may", "me", "meant", "midst", "might", "million",
            "millions", "money", "month", "more", "mortgage", "most", "mounted", "mr", "much", "murdoch", "my",
            "nature", "nearly", "net", "new", "night", "no", "not", "nothing", "now", "obtained", "of", "office",
            "officer", "official", "on", "one", "ones", "only", "or", "other", "outsize", "over", "owe", "owed",
            "owes", "own", "painted", "part", "partnership", "partnerships", "past", "pay", "peanut", "perceived",
            "percent", "percentage", "personal", "personally", "picks", "picture", "place", "played", "player", "pnc",
            "position", "posted", "present", "president", "pressuring", "previous", "primarily", "profitability",
            "profits", "properties", "property", "propped", "published", "pumped", "punishing", "push", "pushed",
            "put", "puts", "rare", "really", "realty", "rebellious", "receive", "received", "recent", "recently",
            "records", "reelected", "refinancing", "refund", "refusing", "regular", "regulation", "regulators",
            "relationship", "released", "reluctance", "repay", "repaying", "repeatedly", "reported", "reputation",
            "require", "required", "requirement", "resort", "response", "responsible", "retired", "revealed",
            "revenue", "review", "richard", "risks", "rosy", "ruling", "run", "runup", "said", "sale", "sales",
            "san", "satisfied", "saying", "scion", "scott", "sealed", "secretary", "securities", "seemingly", "sell",
            "senior", "served", "service", "share", "ship", "should", "show", "shown", "shows", "significant", "since",
            "single", "sink", "sitting", "situation", "small", "sociopath", "sold", "some", "soon", "source", "speaks",
            "spent", "spot", "spree", "steep", "step", "stocks", "stop", "strategy", "strength", "stress", "struggling",
            "subject", "success", "suggest", "take", "tax", "taxes", "taxreturn", "teaches", "televised", "term",
            "than", "that", "the", "their", "them", "they", "theyre", "things", "those", "through", "thursday", "times",
            "timess", "tiny", "to", "total", "totals", "tower", "town", "toxic", "track", "transform", "treasury",
            "trouble", "trump", "trumps", "trust", "try", "trying", "two", "under", "underleveraged", "underlevered",
            "university", "unusual", "up", "us", "using", "usually", "vast", "version", "vice", "vornado", "was",
            "washington", "well", "went", "were", "what", "when", "whether", "which", "who", "why", "will", "willing",
            "willingness", "with", "withdrew", "within", "without", "worth", "would", "wrong", "years", "york", "you",
            "your"};

    public static void main(String[] args) {

        GeneratorText generatorText = new GeneratorText();
        generatorText.getFiles(null, 2, 1000, arrWords, 2);

    }
}
