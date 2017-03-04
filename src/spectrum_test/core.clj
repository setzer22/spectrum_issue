(ns spectrum-test.core
  (:require [spectrum.check :as check]
            [clojure.spec :as spec])
  (:gen-class))

(spec/def ::a string?)

(spec/def ::b int?)

(spec/def ::foo
  (spec/keys :req [::a ::b]))

(spec/conform ::foo {::a "foo", ::b 12})

(spec/fdef mk-foo
           :args (spec/cat :a string?, :b int?)
           :ret ::foo)

(defn mk-foo [a b]
  {::a a ::b b})




